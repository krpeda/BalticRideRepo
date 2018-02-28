import {HttpClient, json} from 'aurelia-fetch-client';

export class Dest {

  rideList = {}

  addRidez() {
   let client = new HttpClient();

   client.fetch('http://localhost:9000/#/destination', {
      'method': 'POST',
      'body': json(this.rideList)
    })
    .then(response => response.text())
    .then(data => {
      console.log(this.rideList);
      this.rideList = {}
    })
    .catch(error => {
      console.log('Error saving comment!' + error.message);
    });
 }
}
