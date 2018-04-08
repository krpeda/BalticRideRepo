import {HttpClient, json} from 'aurelia-fetch-client';

export class Profile {

   clicked = false;
   opened = false;
  
  addCar() {
    let client = new HttpClient();;
    let carInfo = {}

    client.fetch('http://localhost:8080/cars/add', {
      'method':'post',
      'body':JSON.stringify({ 
        "carModel": this.carInfo.carModel,
        "carRegistrationNumber": this.carInfo.carRegistrationNumber, 
        "carYear": this.carInfo.carYear,
        "userId": this.user.uid
        })
    })
      .then(response => response.json())
      .then(data => {
        console.log(data.carInfo);
      })
      this.carInfo= {};
      this.opened = !this.opened;
      this.clicked = !this.clicked; // toggle clicked true/false
    }
   openModal() {
     this.opened = !this.opened;
     this.clicked = !this.clicked; // toggle clicked true/false
    return true;
   }
  }

