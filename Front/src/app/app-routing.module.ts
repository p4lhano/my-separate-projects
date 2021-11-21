import { DeleteSetorComponent } from './components/views/setor/delete-setor/delete-setor.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarFuncionarioComponent } from './components/views/funcionario/cadastrar-funcionario/cadastrar-funcionario.component';
import { DeleteFuncionarioComponent } from './components/views/funcionario/delete-funcionario/delete-funcionario.component';
import { ListarFuncionarioComponent } from './components/views/funcionario/listar-funcionario/listar-funcionario.component';
import { CadastrarSetorComponent } from './components/views/setor/cadastrar-setor/cadastrar-setor.component';
import { ListarSetorComponent } from './components/views/setor/listar-setor/listar-setor.component';
import { TesteFormularioComponent } from './components/views/funcionario/teste-formulario/teste-formulario.component';
import { ListarFuncionarioHomeComponent } from './components/views/funcionario/listar-funcionario-home/listar-funcionario-home.component';
import { RegistroNowComponent } from './components/views/ponto/registro-now/registro-now.component';

const routes: Routes = [
    {
        path: "",
        component: ListarFuncionarioHomeComponent
    },{
        path: "funcionario/all",
        component: ListarFuncionarioComponent
    },{
        path: "funcionario/new",
        component: CadastrarFuncionarioComponent
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
        path: "setor/delete/:id",
        component: DeleteSetorComponent
    },{
        path: "setor/update/:setorId",
        component: CadastrarSetorComponent
    },{
        path: "teste",
        component: TesteFormularioComponent
    },{
        path: "registrarponto/:id",
        component: RegistroNowComponent
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
