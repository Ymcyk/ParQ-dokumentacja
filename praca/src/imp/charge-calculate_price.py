def calculate_price(self, time):
    price = Decimal()
    price += Decimal(time // self.minutes) * self.cost
    rest = (Decimal(time % self.minutes) / self.minutes) * self.cost
    if not self.minute_billing and rest:
        price += self.cost
    else:
        price += rest
    return price
