import {HttpClient, json} from 'aurelia-fetch-client';

export class Dest {

  
  addRide() {

    let client = new HttpClient();

    let rideList = {
      "start": "Tallinn",
      "dest": 11
    }

    client.fetch('http://localhost:8080/rides/add', {
      'method': "POST",
      'body':json(rideList)
    })
      .then(response => response.json())
      .then(data => {
          console.log('Olemas ' + data.start);
      });
 }
}
