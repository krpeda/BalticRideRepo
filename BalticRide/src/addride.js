import {HttpClient, json} from 'aurelia-fetch-client';

export class AddRide { 
  addRide() {

    let client = new HttpClient();

    let rideList = {}

   if (this.rideList.endpoint == null || this.rideList.startpoint == null || this.rideList.starttime == null || this.rideList.freeseats == null || this.rideList.ridefee == null  ) {
     alert("Please fill all fields");
   } else {
    client.fetch('http://localhost:8080/rides/add', {
      'method': "POST",
      'body':json(this.rideList)
    })
      .then(response => response.json())
      .then(data => {
          console.log('Olemas ' + data.startpoint);
          alert('Ride added successfully!');
      });
      this.rideList = {}
   }
 }
 activate() {
  let client = new HttpClient();
  client.fetch('http://localhost:8080/user/car' ,{
      'method': "POST",
      'body':json(this.user)
    })
      .then(response => response.json())
      .then(cars => this.carList = cars);
 }
}
