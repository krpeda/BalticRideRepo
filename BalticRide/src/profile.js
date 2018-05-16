import {HttpClient, json} from 'aurelia-fetch-client';

export class Profile {

   clicked = false;
   opened = false;
   hasJoined = 0;

  
  addCar() {
    location.reload();
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
        "carYear": this.carInfo.carYear,
        "carPicture":this.carInfo.carPicture
        })
    })
      .then(response => response.json())
      .then(data => {
      })
      this.carInfo= {};
      this.opened = !this.opened;
      this.clicked = !this.clicked; // toggle clicked true/false
    }
    activate() {
      let userId = firebase.auth().currentUser.uid;
      let client = new HttpClient();
      client.fetch('http://localhost:8080/user/'+userId+'/cars')
      .then(response => response.json())
      .then(cars => this.carList = cars);

      client.fetch('http://localhost:8080/user/'+userId+'/messages')
        .then(response => response.json())
        .then(messages => {
            this.messageList = messages;
            console.log(this.messageList);
            this.hasJoined = this.messageList.length;
            console.log(this.hasJoined)
        })

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

