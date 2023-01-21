import { LoginService } from './../../../services/login.service';
import { Login } from './../../../models/login';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-login',
  templateUrl: './home-login.component.html',
  styleUrls: ['./home-login.component.css']
})
export class HomeLoginComponent implements OnInit {

  constructor(private service : LoginService, private router: Router) { }

  hide = true;
  login! : String;
  senha! : String;

  ngOnInit(): void {
  }
  realizarLogin(): void{
    let login : Login = {
        login : this.login,
        senha : this.senha
    };
    this.service.realizarLogin(login).subscribe(login => {
        console.log("Login realizado - " + login);
        this.router.navigate(["funcionario/pontos"]);
    });
  }

}
