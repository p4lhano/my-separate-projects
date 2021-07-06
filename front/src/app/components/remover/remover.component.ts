import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ComputadorService } from 'src/app/services/computador.service';

@Component({
  selector: 'app-remover',
  templateUrl: './remover.component.html',
  styleUrls: ['./remover.component.css']
})
export class RemoverComponent implements OnInit {

  constructor(private service: ComputadorService, private router: Router) { }

  ngOnInit(): void {

  }

  remover(id:string){
    
  }

}
