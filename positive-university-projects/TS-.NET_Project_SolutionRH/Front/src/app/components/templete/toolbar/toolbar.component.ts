import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-toolbar-nav',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {

    public NomePagina!: String;

  constructor() { }

  ngOnInit(): void {
  }

}
