import {HttpClient, json} from 'aurelia-fetch-client';
import moment from 'moment';

export class All {

  findList = []
  
  
  activate() {
    let client = new HttpClient();
    client.fetch('http://localhost:8080/search/'+this.startPoint+'/'+this.endPoint+'/'+this.startTime)
      .then(response => response.json())
      .then(find => {
        /*this.rideList.startTime = moment.unix(this.rideList.startTime).format("yyyy-MM-dd HH:mm");*/
        this.findList = find; 
        for (var i = 0; i < find.length; i++) {
          find[i].startTime = moment(find[i].startTime).format("DD-MM-YYYY HH:mm");
      }
      });
  }
}
