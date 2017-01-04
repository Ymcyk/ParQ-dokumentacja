lot = ScheduleLot.objects.create(name='Strefa A')
start = timezone.make_aware(datetime(2016, 12, 25, 8))
end = timezone.make_aware(datetime(2016, 12, 25, 17))
rule = Rule.objects.create(frequency='WEEKLY', name='weekly')
sch = Schedule.objects.create(start=start, end=end,
rule=rule, schedule_lot=lot)
cha = Charge.objects.create(cost=1, minutes=60, duration=60)
ScheduleCharge.objects.create(schedule=sch, charge=cha)
