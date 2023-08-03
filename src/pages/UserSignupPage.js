import React from "react";
import {signup} from '../api/apiCalls'

class UserSignupPage extends React.Component{ 
    //export class UserSignupPage extends React.Component

 state = {
    username: null,
    displayname: null,
    password: null,
    passwordrepeat: null,
    pendingApiCall: false
 };

onChange = event => {
    // const value = event.target.value;
    // const name = event.target.name;

    const { name, value } = event.target;
    //eventin target objesindeki içerisindeki name i al ve 
    //targettaki value değerini al gibi düşünülebilir

    this.setState({
        [name]: value
    });
};

//  onChangeUserName = event => {
//     this.setState({
//         username: event.target.value
//     });   
//  };
// //   onChangeUserName = {function(event){
// //   console.log(event.target) }} 

//  onChangeDisplayName = event => {
//     this.setState({
//         displayname: event.target.value
//     });   
//  };

//  onChangePassword = event => {
//     this.setState({
//         password: event.target.value
//     });   
//  };

//  onChangePasswordRepeat = event => {
//     this.setState({
//         passwordrepeat: event.target.value
//     });   
//  };

onClickSignUp = async event => {
  event.preventDefault();

//   const body = {
//     username: this.state.username,
//     displayname: this.state.displayname ,
//     password: this.state.password
//   }

  const { username, displayname, password, } = this.state;

  const body = {
    username,
    displayname,
    password
  }
  this.setState({ pendingApiCall: true})
 
  //axios.post('http://localhost:8080/api/1.0/users' , body)
  //axios.post('/api/1.0/users' , body)
  // signup(body)
  // .then((response)=>{
  //   this.setState({ pendingApiCall:false});
  // }).catch(eror => {
    
  // });
 
  try {
    const response = await signup(body);
    //this.setState({ pendingApiCall:false});
  }catch(eror){
    //this.setState({ pendingApiCall:false});
  }
   
  this.setState({ pendingApiCall:false});

};

    render(){
     return (
      <div className="container">
         <from>
           
           <h1 className="text-center">Sign Up</h1>
           
           {/* <div>
            <label>User Name</label>
            <input onChange={this.onChangeUserName}/>
           </div> */}

           <div className="form-group">
            <label>User Name</label>
            <input className="form-control" name= "username" onChange={this.onChange}/>
           </div>
           
           <div>
            <label>Display Name</label>
            <input className="form-control" name= "displayname" onChange={this.onChange}/>
           </div>

           <div>
            <label>Password</label>
            <input className="form-control" name= "password" type="password" onChange={this.onChange}/>
           </div>

           <div>
            <label>Password Repeat</label>
            <input className="form-control" name= "passwordrepeat" type="password" onChange={this.onChange}/>
           </div>
           
           <div className="text-center">
            <button className="btn btn-primary" 
            onClick={this.onClickSignUp}
            disabled={this.state.pendingApiCall}
            >Sign Up
            </button>
           </div>
           
          </from>  
      </div>      
     ); 
    }
} 

export default UserSignupPage;