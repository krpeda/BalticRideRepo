import {HttpClient, json} from 'aurelia-fetch-client';

export class FindRide {

  rideList = []

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
}
