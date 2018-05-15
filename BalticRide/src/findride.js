import {HttpClient, json} from 'aurelia-fetch-client';

export class FindRide {

  rideList = []
  hasJoined = 0;


  findRide() {
    let client = new HttpClient();

    client.fetch('http://localhost:8080/search/'+this.startPoint+'/'+this.endPoint)
      .then(response => response.json())
      .then(data => {
        console.log(this.startPoint + this.endPoint)
      })
      
  }
  
  showRides() {

    let client = new HttpClient();
    client.fetch('http://localhost:8080/rides')
      .then(response => response.json())
      .then(data => {
        console.log('from ' + this.rideList.startpoint +  ' to ' + this.rideList.endpoint);
      })
  }
  activate() {
    if(this.userLoggedIn) {
      let client = new HttpClient();
    const userId = firebase.auth().currentUser.uid;
    client.fetch('http://localhost:8080/user/'+userId+'/messages')
        .then(response => response.json())
        .then(messages => {
            this.messageList = messages;
            console.log(this.messageList);
            this.hasJoined = this.messageList.length;
            console.log(this.hasJoined)
        })
    }
  }
}
