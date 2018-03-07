import {HttpClient, json} from 'aurelia-fetch-client';

export class All {

  

  rideList = []
  
  activate() {

    let client = new HttpClient();
    client.fetch('http://localhost:8080/rides')
      .then(response => response.json())
      .then(rides => this.rideList = rides);
  }
}
