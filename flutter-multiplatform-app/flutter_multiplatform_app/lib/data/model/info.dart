final class Info {
  const Info({
    this.count,
    this.pages,
    this.next,
    this.prev,
  });

  final int? count;
  final int? pages;
  final String? next;
  final String? prev;

  Info.fromJson(Map<String, dynamic> json)
      : count = json['count'] as int?,
        pages = json['pages'] as int?,
        next = json['next'] as String?,
        prev = json['prev'] as String?;
}
