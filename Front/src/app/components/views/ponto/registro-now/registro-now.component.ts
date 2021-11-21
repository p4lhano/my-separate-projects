import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PontoFuncionarioService } from 'src/app/services/pontoFuncionario.service';

@Component({
  selector: 'app-registro-now',
  templateUrl: './registro-now.component.html',
  styleUrls: ['./registro-now.component.css']
})
export class RegistroNowComponent implements OnInit {

    id!:number;
    constructor(private service: PontoFuncionarioService, private rota: ActivatedRoute, private router: Router) { }


  ngOnInit(): void {
    this.rota.params.subscribe((params) => {
        this.service.registrarPonto(params.id).subscribe();
        this.router.navigate([""]);
    });
}

}
