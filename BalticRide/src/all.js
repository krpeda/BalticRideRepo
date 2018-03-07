import {HttpClient, json} from 'aurelia-fetch-client';

export class All {

  

  rideList = [
    {"startpoint": "Tallinn",
    "endpoint": "riga",
    "starttime" :23,
    "freeseats": 2,
    "ridefee": 50
  },
  {"startpoint": "Tallinn",
    "endpoint": "riga",
    "starttime" :23,
    "freeseats": 2,
    "ridefee": 50
  },
  {"startpoint": "Tallinn",
    "endpoint": "riga",
    "starttime" :23,
    "freeseats": 2,
    "ridefee": 50
  }
  ]
  
  activate() {

    let client = new HttpClient();
    client.fetch('http://localhost:8080/rides')
      .then(response => response.json())
      .then(rides => this.rideList = rides);
  }
}
