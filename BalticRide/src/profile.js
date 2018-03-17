import {HttpClient, json} from 'aurelia-fetch-client';


export class Profile {
  
  addCar() {
    let client = new HttpClient();

    let car = '';

    client.fetch('http://localhost:8080/rides/add', {
      'method': "POST",
      'body':json(this.car)
    })
      .then(response => response.json())
      .then(data => {
          console.log('Olemas ' + data.car);
      });
      this.car = '';
  }
}
