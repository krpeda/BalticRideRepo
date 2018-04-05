import {HttpClient, json} from 'aurelia-fetch-client';

export class Profile {

   clicked = false;
   opened = false;
  
  addCar() {
    let client = new HttpClient();

    let car = '';

    client.fetch('http://localhost:8080/cars/add', {
      'method':'post',
      'body':json(this.car)
    })
      .then(response => response.json())
      .then(data => {
          console.log(data.car);
      })
      this.car= '';
   }
   openModal() {
     this.opened = !this.opened;
     this.clicked = !this.clicked; // toggle clicked true/false
    return true;
   }
  }

