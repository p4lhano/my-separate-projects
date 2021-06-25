import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from "@angular/material/table";
import { MedicoService } from "./../../services/medico.service";
import { Medico } from "../../models/medico";
import { Router } from "@angular/router";
import { MatSnackBar } from "@angular/material/snack-bar";


@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})
export class CadastrarComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
