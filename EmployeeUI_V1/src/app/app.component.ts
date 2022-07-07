import { Component, OnInit } from '@angular/core';
import { EmpServiceService } from './emp-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  
  title = 'EmployeeUI';

  //ToDO: Model add
  empName: string = '';
  empsalary: number = 0;

  response: any = {};

  constructor(private empService: EmpServiceService) { }

  ngOnInit(): void {
  }

  saveEmployee(){

    console.log("saveEmployee() called");

    this.empService.saveEmployee(this.empName, this.empsalary).subscribe( 
      data => { console.log("Emp saved", data); this.response = data }, 
      error => { console.error("Emp save failed: ", error); this.response = error ;}
      );

  }



}
