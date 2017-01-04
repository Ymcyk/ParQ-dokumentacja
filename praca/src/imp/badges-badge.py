class Badge(models.Model):
    uuid = models.UUIDField(default=uuid.uuid4, editable=False)

    @property
    def is_assigned(self):
        return hasattr(self, 'vehicle')

    def path_to_file(self):
        path = os.path.join(settings.BASE_DIR, 'badges', 'images')
        return '{0}/{1}.png'.format(path, self.uuid)

    def generate_image(self):
        qr = qrcode.QRCode(
            version=4,
            error_correction=qrcode.constants.ERROR_CORRECT_H,
            box_size=20,
            border=4
            )
        qr.add_data(self.uuid)
        path = os.path.join(settings.BASE_DIR, 'badges', 'images')
        return qr.make_image().save(self.path_to_file())
