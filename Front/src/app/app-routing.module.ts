import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarFuncionarioComponent } from './components/views/funcionario/cadastrar-funcionario/cadastrar-funcionario.component';
import { ListarFuncionarioComponent } from './components/views/funcionario/listar-funcionario/listar-funcionario.component';

const routes: Routes = [
    {
        path: "",
        component: ListarFuncionarioComponent
    },{
        path: "funcionario/all",
        component: ListarFuncionarioComponent
    },{
        path: "funcionario/new",
        component: CadastrarFuncionarioComponent
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
