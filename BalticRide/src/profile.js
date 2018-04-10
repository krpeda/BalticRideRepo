import {HttpClient, json} from 'aurelia-fetch-client';

export class Profile {

   clicked = false;
   opened = false;


  
  addCar() {
    let client = new HttpClient();
    let carInfo = {}
    const userId = firebase.auth().currentUser.uid;
    let carList = []

    client.fetch('http://localhost:8080/cars/add', {
      'method':'post',
      'body':JSON.stringify({ 
        "userId": userId,
        "carModel": this.carInfo.carModel,
        "carRegistrationNumber": this.carInfo.carRegistrationNumber, 
        "carYear": this.carInfo.carYear
        })
    })
      .then(response => response.json())
      .then(data => {
      })
      this.carInfo= {};
      this.opened = !this.opened;
      this.clicked = !this.clicked; // toggle clicked true/false
      location.reload();

    }
    activate() {
      const userId = firebase.auth().currentUser.uid;

      let client = new HttpClient();
      client.fetch('http://localhost:8080/user/'+userId+'/cars')
      .then(response => response.json())
      .then(cars => this.carList = cars);
    }
   openModal() {
     this.opened = !this.opened;
     this.clicked = !this.clicked; // toggle clicked true/false
    return true;
   }
   closeModal() {
     this.clicked = false;
     this.opened = false;
   }
   deleteCar(cars) {
    let index = this.carList.indexOf(cars);
    let client = new HttpClient();
    let carId = cars.carId;

    if(index !== -1) {
        this.carList.splice(index, 1);
    }
    client.fetch('http://localhost:8080/cars/'+carId+'/delete', {
          'method':'get'
           })
        .then(response => response.json())
        .then(data => {

      })
   }
   
  }

