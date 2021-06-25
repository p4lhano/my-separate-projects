import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarComponent } from './components/cadastrar/cadastrar.component';
import { ListarComponent } from './components/listar/listar.component';

const routes: Routes = [
  {
    path: '',
    component: ListarComponent
  },{
    path: '/medico/cadastrar',
    component: ListarComponent
  },{
    path: '/medico/listar',
    component: ListarComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }