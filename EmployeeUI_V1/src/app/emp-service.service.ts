import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable as Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmpServiceService {

  constructor(private http: HttpClient) { }

  saveEmployee(empName: string, empsalary: number){

    const request = {
      name: empName,
      salary: empsalary
    };

    //ToDO: remove hardcode url to env file
    return this.http.post("http://localhost:8080/", request);

  }
}
