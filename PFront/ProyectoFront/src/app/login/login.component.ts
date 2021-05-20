import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { ApirestService } from '../Services/apirest.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  username:string;
  password:string;
  message: any;
  

  constructor(private service:ApirestService,private router:Router) { }

  ngOnInit(): void {
  }

  doLogin(){
    let resp =this.service.login(this.username,this.password);

    resp.subscribe(data=>{
      console.log(data)
      this.router.navigate(["/home"])

    });
  }

}
