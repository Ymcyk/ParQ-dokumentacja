from django.db import models
from charges.models import ScheduleLot

class Parking(models.Model):
    name = models.CharField(
            _('name'),
            max_length=50,
            )
    description = models.CharField(
            _('description'),
            max_length=150,
            blank=True,
            null=True,
            )
    schedule_lot = models.OneToOne(ScheduleLot)

    def __str__(self):
        return self.name
