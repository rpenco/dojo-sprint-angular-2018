import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContentComponent } from './content/content.component';
import { CompareComponent } from './compare/compare.component';
import { CreateComponent } from './create/create.component';
import { GraphsComponent } from './graphs/graphs.component';

const routes: Routes = [
  {path: '', redirectTo: '/technos', pathMatch: 'full'},

  {path: 'technos', children: [
    {path: '', component: ContentComponent},
    {path: ':id', component: ContentComponent}
  ]},

  {path: 'compare', component: CompareComponent},
  {path: 'create', component: CreateComponent},
  {path: 'stats', component: GraphsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
