import { DeletarSetorComponent } from './components/views/setor/deletar-setor/deletar-setor.component';
import { DeletarFuncionarioComponent } from './components/views/funcionario/deletar-funcionario/deletar-funcionario.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarFuncionarioComponent } from './components/views/funcionario/cadastrar-funcionario/cadastrar-funcionario.component';
import { DeleteFuncionarioComponent } from './components/views/funcionario/delete-funcionario/delete-funcionario.component';
import { ListarFuncionarioComponent } from './components/views/funcionario/listar-funcionario/listar-funcionario.component';
import { CadastrarSetorComponent } from './components/views/setor/cadastrar-setor/cadastrar-setor.component';
import { ListarSetorComponent } from './components/views/setor/listar-setor/listar-setor.component';

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
    },{
        path: "funcionario/deletar",
        component: DeletarFuncionarioComponent
    },{
        path: "funcionario/update/:id",
        component: CadastrarFuncionarioComponent
    },{
        path: "funcionario/delete/:id",
        component: DeleteFuncionarioComponent
    },{
        path: "setor/new",
        component: CadastrarSetorComponent
    },{
        path: "setor/all",
        component: ListarSetorComponent
    },{
        path: "setor/deletar",
        component: DeletarSetorComponent
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
