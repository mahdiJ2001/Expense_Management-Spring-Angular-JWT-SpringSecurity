import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';

import { LoginResponse } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = '';
  password: string = '';


  constructor(private authService: AuthService) { }

  onLogin() {
    this.authService.login(this.email, this.password).subscribe(
      (response: LoginResponse) => {
        console.log('Login successful', response);
        localStorage.setItem('token', response.token);
      },
      (error: any) => {
        console.error('Login failed', error);
      }
    );
  }
}
