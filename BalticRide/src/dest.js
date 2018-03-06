import {HttpClient, json} from 'aurelia-fetch-client';

export class Dest {

  addRidez() {
    
   let client = new HttpClient();

   client.fetch('http://localhost:8080/add/rides', {
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
