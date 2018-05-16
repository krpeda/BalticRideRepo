import {HttpClient, json} from 'aurelia-fetch-client';

export class Messages {

  hasJoined = 0;

  messageList = []

  
  activate() {
    let client = new HttpClient();
    const userId = firebase.auth().currentUser.uid;
    client.fetch('http://localhost:8080/user/'+userId+'/messages')
        .then(response => response.json())
        .then(messages => {
            this.messageList = messages;
            this.hasJoined = this.messageList.length;
        })
     }
     deleteMessage(messages) {
      location.reload();
      let index = this.messageList.indexOf(messages);
      let client = new HttpClient();
      let messageId = messages.messageId;
      console.log(messageId);

  
      if(index !== -1) {
          this.messageList.splice(index, 1);
      }
      client.fetch('http://localhost:8080/messages/'+messageId+'/delete', {
            'method':'get'
             })
          .then(response => response.json())
          .then(data => {
            
        })
     }
  }

