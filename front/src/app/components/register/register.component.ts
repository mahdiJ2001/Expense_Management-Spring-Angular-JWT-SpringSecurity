import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,

  ]
})
export class RegisterComponent {
  registerForm: FormGroup;
  registrationError: string = '';
  roles = ['ADMIN', 'USER'];

  constructor(private fb: FormBuilder, private authService: AuthService) {
    this.registerForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
      role: ['', Validators.required]
    });
  }

  get f() { return this.registerForm.controls; }

  registerUser() {
    if (this.registerForm.invalid) {
      return;
    }

    this.authService.register(this.registerForm.value).subscribe(
      response => {
        console.log('Registration successful:', response);
        this.registerForm.reset();
        this.registrationError = '';
      },
      error => {
        console.error('Registration failed:', error);
        if (error.error && error.error.message) {
          this.registrationError = error.error.message;
        } else {
          this.registrationError = 'Registration failed. Please try again later.';
        }
      }
    );
  }
}
