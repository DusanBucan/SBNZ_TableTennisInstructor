import { Component, OnInit } from '@angular/core';
import { SkillService } from 'src/app/services/skill-service/skill.service';
import { SkillEntity } from 'src/app/models/skill-model/skill.model';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-skill-list',
  templateUrl: './skill-list.component.html',
  styleUrls: ['./skill-list.component.scss']
})
export class SkillListComponent implements OnInit {

  private skills: SkillEntity[];
  displayedColumns: string[] = ['id', 'skill', 'skillLvl', 'executionDescription', 'skillGroup', 'actions'];
  dataSource;

  constructor(private skillService: SkillService) {
     this.dataSource = null;
  }

  fillTable() {
    this.skillService.getAll().subscribe(res => {
      this.skills = res as SkillEntity[];
      console.log(this.skills);
      this.dataSource = new MatTableDataSource(
        this.skills.map(t => {
          return {
            id : t.skillId,
            skillName: t.name,
            skillLvl: t.skillLevel,
            executionDescription : t.executionDescription,
            skillGroup: t.skillGroup
          };
        })
      );
    });
  }

  ngOnInit() {
    this.fillTable();
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  deleteSkill(id: number) {
    this.skillService.deleteSkill(id).subscribe(() => {
      this.fillTable();
    });
  }

}
