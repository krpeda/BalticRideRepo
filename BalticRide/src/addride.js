import {HttpClient, json} from 'aurelia-fetch-client';


export class AddRide { 
  addRide() {

    let client = new HttpClient();

    let rideList = {}

   if (this.rideList.endPoint == null || this.rideList.startPoint == null || this.rideList.startTime == null || this.rideList.freeSeats == null || this.rideList.rideFee == null  ) {
     alert("Please fill all fields");
   } else {
    console.log(JSON.stringify(this.rideList));
    client.fetch('http://localhost:8080/rides/add', {
      'method': "POST",
      'body':json(this.rideList)
    })
      .then(response => response.json())
      .then(data => {
          console.log('Olemas ' + this.rideList.startTime);
          alert('Ride added successfully!');
      });
      this.rideList = {}
   }
  }/*
 activate() {
  let client = new HttpClient();
  client.fetch('http://localhost:8080/user/car' ,{
      'method': "POST",
      'body':json(this.user)
    })
      .then(response => response.json())
      .then(cars => this.carList = cars);
 }*/
}
