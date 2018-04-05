import {HttpClient, json} from 'aurelia-fetch-client';

export class AddCar { 
  addCar() {

    let client = new HttpClient();

    let carList = {}

   if (this.carList.id == null || this.carList.carRegistrationNumber == null || this.carList.carModel == null ||  this.carList.carYear == null) {
     alert(Please fill all fields);
   } else {
    client.fetch('http://localhost:8080/cars/add', {
      'method' POST,
      'body'json(this.carList)
    })
      .then(response = response.json())
      .then(data = {
          console.log('Olemas ' + data.startpoint);
          alert('Car added successfully!');
      });
      this.carList = {}
   }
 }
}