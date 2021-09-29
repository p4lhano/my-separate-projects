import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SetorService } from 'src/app/services/setor.service';

@Component({
    selector: 'app-delete-setor',
    templateUrl: './delete-setor.component.html',
    styleUrls: ['./delete-setor.component.css']
})
export class DeleteSetorComponent implements OnInit {

    constructor(private service: SetorService, private rota: ActivatedRoute, private router: Router) { }

    ngOnInit(): void {
        this.rota.params.subscribe((params) => {
            this.service.delete(params.id).subscribe();
            this.router.navigate(["setor/all"]);
        });
    }

}
