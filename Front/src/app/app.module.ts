import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { ListarFuncionarioComponent } from './components/views/funcionario/listar-funcionario/listar-funcionario.component';
import { ListarFuncionarioHomeComponent } from './components/views/funcionario/listar-funcionario-home/listar-funcionario-home.component';
import { CadastrarFuncionarioComponent } from './components/views/funcionario/cadastrar-funcionario/cadastrar-funcionario.component';
import { ListarSetorComponent } from './components/views/setor/listar-setor/listar-setor.component';
import { CadastrarSetorComponent } from './components/views/setor/cadastrar-setor/cadastrar-setor.component';
import { DeleteFuncionarioComponent } from './components/views/funcionario/delete-funcionario/delete-funcionario.component';
import { DeleteSetorComponent } from './components/views/setor/delete-setor/delete-setor.component';
import { TesteFormularioComponent } from './components/views/funcionario/teste-formulario/teste-formulario.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToolbarComponent } from './components/templete/toolbar/toolbar.component';
import { FormsModule } from '@angular/forms';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatCommonModule } from '@angular/material/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatTableModule } from '@angular/material/table';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatMenuModule } from '@angular/material/menu';
import { MatInputModule } from "@angular/material/input";
import { MatSelectModule } from '@angular/material/select';
import { MatDividerModule } from '@angular/material/divider';
import { ReactiveFormsModule} from '@angular/forms';
import { MatNativeDateModule} from '@angular/material/core';
import { MatListModule} from '@angular/material/list';
import { RegistroNowComponent } from './components/views/ponto/registro-now/registro-now.component';
import  {MatSnackBarModule} from '@angular/material/snack-bar';
import { RegistrosAllComponent } from './components/views/ponto/registros-all/registros-all.component';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import { HomeLoginComponent } from './components/views/home-login/home-login.component';
import { FolhaPontoComponent } from './components/views/ponto/folha-ponto/folha-ponto.component';
import {MatDialogModule} from '@angular/material/dialog';
import {LOCALE_ID, DEFAULT_CURRENCY_CODE} from '@angular/core';
import localePt from '@angular/common/locales/pt';
import {registerLocaleData} from '@angular/common';

registerLocaleData(localePt, 'pt');


@NgModule({
  declarations: [
    AppComponent,
    ListarFuncionarioComponent,
    CadastrarFuncionarioComponent,
    ListarSetorComponent,
    CadastrarSetorComponent,
    ToolbarComponent,
    DeleteFuncionarioComponent,
    DeleteSetorComponent,
    TesteFormularioComponent,
    ListarFuncionarioHomeComponent,
    RegistroNowComponent,
    RegistrosAllComponent,
    HomeLoginComponent,
    FolhaPontoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatCommonModule,
    MatButtonModule,
    MatCardModule,
    MatGridListModule,
    MatFormFieldModule,
    MatTableModule,
    MatSidenavModule,
    MatMenuModule,
    MatInputModule,
    MatSelectModule,
    MatDividerModule,
    MatNativeDateModule,
    ReactiveFormsModule,
    MatListModule,
    MatSnackBarModule,
    MatButtonToggleModule,
    MatDialogModule
  ],
  providers: [
    {
        provide: LOCALE_ID,
        useValue: 'pt'
    },{
    provide:  DEFAULT_CURRENCY_CODE,
    useValue: 'BRL'
    },
],
  bootstrap: [AppComponent]
})
export class AppModule { }
