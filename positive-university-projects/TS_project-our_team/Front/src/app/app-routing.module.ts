import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastarAtividadeComponent } from './components/views/atividades/cadastrar/cadastrar.component';
import { ListarAtividadeComponent } from './components/views/atividades/listar/listar.component';
import { ListarFuncionarioComponent } from './components/views/funcionario/listar/listar.component';
import { CadastarFuncionarioComponent } from './components/views/funcionario/cadastar/cadastar.component'

const routes: Routes = [
  {
    path: '',
    component: ListarAtividadeComponent
  },
  {
    path: 'atividade/cadastrar',
    component: CadastarAtividadeComponent
  },
  {
    path: 'funcionario/listar',
    component: ListarFuncionarioComponent
  },
  {
    path: 'funcionario/cadastrar',
    component: CadastarFuncionarioComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
