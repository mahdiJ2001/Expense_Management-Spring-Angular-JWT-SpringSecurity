import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface LoginResponse {
  token: string;
}

export interface RegisterResponse {
  message: string
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loginUrl = 'http://localhost:8090/auth/login';
  private registerUrl = 'http://localhost:8090/auth/register';
  constructor(private http: HttpClient) { }

  login(email: string, password: string): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(this.loginUrl, { email, password });
  }

  register(user: { firstName: string; lastName: string; email: string; phone: string; password: string; role: string }): Observable<RegisterResponse> {
    return this.http.post<RegisterResponse>(this.registerUrl, user);
  }
}
