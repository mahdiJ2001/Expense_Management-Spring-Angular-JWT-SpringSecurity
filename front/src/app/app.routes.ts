import { Routes } from '@angular/router';
import { RegisterComponent } from '../app/components/register/register.component';
import { AppComponent } from '../app/app.component';

export const appRoutes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'home', component: AppComponent },
    { path: 'register', component: RegisterComponent }
];

export default appRoutes;
