import {HttpClient, json} from 'aurelia-fetch-client';
import moment from 'moment';

export class All {

  rideList = []
  
  activate() {
    let client = new HttpClient();
    client.fetch('http://localhost:8080/rides')
      .then(response => response.json())
      .then(rides => {
        /*this.rideList.startTime = moment.unix(this.rideList.startTime).format("yyyy-MM-dd HH:mm");*/
        this.rideList = rides; 
        for (var i = 0; i < rides.length; i++) {
            rides[i].startTime = moment(rides[i].startTime).format("DD-MM-YYYY HH:mm");
        }
      });
  }
  onClickJoin(rides) {
    let index = this.rideList.indexOf(rides);
    let rideId = this.rideList[index].id;
    const userId = firebase.auth().currentUser.uid;
    let car = this.rideList[index].rideCar.userId;
    console.log(car);
    console.log(userId);
    console.log(rideId);
  }
}
