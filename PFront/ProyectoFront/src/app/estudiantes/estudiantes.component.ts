import { Component, OnInit } from '@angular/core';
import { Estudiante } from '../model/estudiante';
import { ApirestService } from '../Services/apirest.service';

@Component({
  selector: 'app-estudiantes',
  templateUrl: './estudiantes.component.html',
  styleUrls: ['./estudiantes.component.css']
})
export class EstudiantesComponent implements OnInit {

  
  estudiante = new Estudiante();
  submitted = false;
  msgError = '';

  constructor(private service: ApirestService) { }

  ngOnInit(): void {
  }
  create(){
    const data = {

      codigo: this.estudiante.codigo,
      nombres: this.estudiante.nombres,
      apellidos: this.estudiante.apellidos,
      celular: this.estudiante.celular,
      carrera: this.estudiante.carrera,
      usuario: this.estudiante.usuario,
      contrasenia: this.estudiante.contrasenia,

      id: this.estudiante.id,
      userName : this.estudiante.userName,
      password : this.estudiante.password,
      active: this.estudiante.active,
      roles : this.estudiante.roles



    };

    this.service.createEstudiantes(data)
      .subscribe(
        response => {
          this.submitted=true;
          console.log(response);
        },
        error => {
          this.msgError  = error.message +' \n '+ error.error.message;
          console.log(error);
        });

        this.service.createUser(data)
        .subscribe(
          response => {
            this.submitted=true;
            console.log(response);
          },
          error => {
            this.msgError  = error.message +' \n '+ error.error.message;
            console.log(error);
          });

          this.service.sms(data)
          .subscribe(
            response=>{
              this.submitted=true;
              console.log(response);
            },
            error => {
              this.msgError  = error.message +' \n '+ error.error.message;
              console.log(error);
            });
          

  }

  newMateria() {
    this.submitted = false;
    this.estudiante.codigo = null;
    this.estudiante.nombres= null;
    this.estudiante.apellidos= null;
    this.estudiante.celular= null;
    this.estudiante.carrera= null;
    this.estudiante.usuario= null;
    this.estudiante.contrasenia= null;

    this.estudiante.id = null;
    this.estudiante.userName= null;
    this.estudiante.password= null;
    this.estudiante.active= null;
    this.estudiante.roles= null;
  }

}
