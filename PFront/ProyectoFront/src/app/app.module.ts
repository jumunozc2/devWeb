import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ApirestService } from './Services/apirest.service';
import { FormsModule } from '@angular/forms';

import {HttpClientModule} from '@angular/common/http';
import { MateriasComponent } from './materias/materias.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap'
import { ListFilterPipe } from './Services/materiaFilter.service';

import { EstudiantesComponent } from './estudiantes/estudiantes.component';
import { ListFilterPipe2 } from './Services/estudianteFilter.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    MateriasComponent,
    ListFilterPipe,
    ListFilterPipe2,
    EstudiantesComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [ApirestService],
  bootstrap: [AppComponent]
})
export class AppModule { }
