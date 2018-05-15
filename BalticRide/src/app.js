import { RecentRides } from './recentrides';
import {HttpClient, json} from 'aurelia-fetch-client';
import * as moment from 'moment';


export class App {

  constructor(userLoggedIn, authToken, user) {
    const _this = this;
    if (userLoggedIn === void 0) { userLoggedIn = false; }
    if (authToken === void 0) { authToken = null; }
    if (user === void 0) { user = null; }
    this.userLoggedIn = userLoggedIn;
    this.authToken = authToken;
    this.user = user;
    // This mostly gets called on subsequent page loads to determine
    // what the current status of the user is with "user" being an object
    // return by Firebase with credentials and other info inside of it
    firebase.auth().onAuthStateChanged(user => {
        _this.userLoggedIn = user ? true : false;
        _this.user = user;
    });
}
login(type) {
  const _this = this;
  let provider;

  if (type === 'google') {
      provider = new firebase.auth.GoogleAuthProvider();
  }
  if (type === 'facebook') {
      provider = new firebase.auth.FacebookAuthProvider();
  }
  firebase.auth().signInWithPopup(provider).then(result => {
      // The token for this session
      _this.authToken = result.credential.accessToken;
      // The user object containing information about the current user
      _this.user = result.user;
      // Set a class variable to true to state we are logged in
      _this.userLoggedIn = true;
      if(result.additionalUserInfo.isNewUser) {

        let client = new HttpClient();
        let user = {}
        console.log(JSON.stringify({ 
          "userId": this.user.uid,
          "userName":this.user.displayName, 
          "userEmail":this.user.email,
          "userPhoneNumber":this.user.phoneNumber
          }));
        client.fetch('http://localhost:8080/user/add', {
          'method':'post',
          'body': JSON.stringify({ 
            "userId": this.user.uid,
            "userName":this.user.displayName, 
            "userEmail":this.user.email,
            "userPhoneNumber":this.user.phoneNumber
            })
        })
        .then(response => response.json())
        .then(data => {
          console.log('Jep ' + this.user);
        })


      }
  }).catch(error => {
      const errorCode = error.code;
      const errorMessage = error.message;
      const email = error.email;
      const credential = error.credential;
      console.log(error);
  });
}
logout() {
  const _this = this;
  // Self-explanatory signout code
  firebase.auth().signOut().then(() => {
      _this.userLoggedIn = false;
      window.location = "http://localhost:9000"; 
  }).catch(error => {
      throw new Error(error);
  });
}


  configureRouter(config, router) {
    config.title = 'BalticRide';
    config.map([
      {route: '', name: 'findride', moduleId: 'findride', title: 'Find Ride'},
      {route: 'recentrides', name: 'recentrides', moduleId: 'recentrides', title: 'Recent Rides'},
      {route: 'addride', name: 'addride', moduleId: 'addride', title: 'Add Ride'},
      {route: 'rides', name: 'rides', moduleId: 'rides', title: 'Find Ride'},
      {route: 'about', name:'about', moduleId:'about', title:'About Us'},
      {route:'allrides', name:'allrides', moduleId:'allrides', title:'All Rides'},
      {route:'profile', name:'profile', moduleId:'profile', title:'Your Profile'},
      {route:'ridedetails', name:'ridedetails', moduleId:'ridedetails', title:'Ride Details'},
      {route:'messages', name:'messages', moduleId:'messages', title:'Messages'}




    ]);
  }
}
