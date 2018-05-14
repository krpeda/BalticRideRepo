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
        console.log(rides);
      });
  }
  onClickJoin() {
    
  }
}
