def send_badge(recipient, badge):
    email = EmailMessage(
        'ParQ kod QR',
        'Kod w załączniku',
        settings.EMAIL_HOST_USER,
        [recipient],
        [settings.EMAIL_HOST_USER]
        )
    try:
        email.attach_file(badge.path_to_file())
    except FileNotFoundError:
        badge.generate_image()
        email.attach_file(badge.path_to_file())

    email.send()
