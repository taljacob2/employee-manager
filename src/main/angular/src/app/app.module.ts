import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {EmployeeCardComponent} from './component/employee-card/employee-card.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
// --- Start PrimeNg ---
import {ButtonModule} from 'primeng/button';
// PrimeNGTable
import {TableModule} from "primeng/table";
import {FormsModule} from "@angular/forms";
// PrimeNGInputText
import {InputTextModule} from 'primeng/inputtext';
// PrimeNGAutoComplete
import {AutoCompleteModule} from 'primeng/autocomplete';
// Json Pipe
import {CommonModule} from '@angular/common';
// PrimeNG Dialog - Modal
import {DialogModule} from 'primeng/dialog';
import {EditEmployeeDialogComponent} from './component/dialog/edit-employee-dialog.component';
import {InsertEmployeeDialogComponent} from "./component/dialog/insert-employee-dialog.component";
import {AutoCompleteComponent} from './component/auto-complete/auto-complete.component';
import {TableComponent} from './component/table/table.component';
// PrimeNG Phone input
import {InputMaskModule} from 'primeng/inputmask';


@NgModule({
            declarations: [
              AppComponent,
              EmployeeCardComponent,
              EditEmployeeDialogComponent,
              InsertEmployeeDialogComponent,
              AutoCompleteComponent,
              TableComponent
            ],
            imports     : [
              BrowserModule,
              HttpClientModule,
              BrowserAnimationsModule,
              ButtonModule,
              TableModule,
              FormsModule,
              InputTextModule,
              AutoCompleteModule,
              CommonModule,
              DialogModule,
              InputMaskModule
            ],
            providers   : [],
            bootstrap   : [AppComponent]
          })
export class AppModule {}
