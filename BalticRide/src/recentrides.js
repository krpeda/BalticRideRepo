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
        for(let i = 0; i < rides.length; i++){
            let firstRides = rides.splice(0, i);
            firstRides = rides;
        }
      })
  }
  showMore(rides) {
    let index = this.rideList.indexOf(rides);
    if(index !== -1) {
      console.log(this.rideList[index])
      window.location = 'http://localhost:9000/#/ridedetails/' + index
    }
  }
}
