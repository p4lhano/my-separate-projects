import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarComponent } from './componets/cadastrar/cadastrar.component';
import { ListarComponent } from './componets/listar/listar.component';

const routes: Routes = [
  {
      path: "",
      component:ListarComponent
  },{
      path: "filme/all",
      component: ListarComponent
  },{
      path: "filme/new",
      component: CadastrarComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
