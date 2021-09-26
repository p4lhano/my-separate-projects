import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListarFuncionarioComponent } from './components/views/funcionario/listar-funcionario/listar-funcionario.component';
import { CadastrarFuncionarioComponent } from './components/views/funcionario/cadastrar-funcionario/cadastrar-funcionario.component';
import { FormsModule } from '@angular/forms';
import { ListarSetorComponent } from './components/views/setor/listar-setor/listar-setor.component';
import { CadastrarSetorComponent } from './components/views/setor/cadastrar-setor/cadastrar-setor.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {ToolbarComponent} from './components/templete/toolbar/toolbar.component';

import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatCommonModule} from '@angular/material/core';

@NgModule({
  declarations: [
    AppComponent,
    ListarFuncionarioComponent,
    CadastrarFuncionarioComponent,
    ListarSetorComponent,
    CadastrarSetorComponent,
    ToolbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatCommonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
