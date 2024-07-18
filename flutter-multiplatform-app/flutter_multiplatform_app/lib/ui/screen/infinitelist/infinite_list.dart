import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_multiplatform_app/di/get_it.dart';
import 'package:flutter_multiplatform_app/navigation/destination.dart';
import 'package:flutter_multiplatform_app/presentation/data_type_enum.dart';
import 'package:flutter_multiplatform_app/presentation/infinitylist/bloc/infinite_list_bloc.dart';
import 'package:flutter_multiplatform_app/presentation/infinitylist/bloc/infinite_list_event.dart';
import 'package:flutter_multiplatform_app/presentation/infinitylist/bloc/infinite_list_state.dart';
import 'package:flutter_multiplatform_app/ui/widget/infinitelist/bottom_loader.dart';
import 'package:flutter_multiplatform_app/ui/widget/infinitelist/character_list_item.dart';

class InfiniteListRouter extends StatelessWidget {
  const InfiniteListRouter({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: DataTypeEnum.values.map((dataType) {
            return ElevatedButton(
              onPressed: () => {
                Navigator.pushNamed(
                  context,
                  Destination.infiniteListSubScreenRoute,
                  arguments: dataType,
                )
              },
              child: Text(dataType.name.toUpperCase()),
            );
          }).toList(),
        ),
      ),
    );
  }
}

class InfiniteListScreen extends StatelessWidget {
  const InfiniteListScreen({super.key, required this.dataTypeEnum});

  final DataTypeEnum dataTypeEnum;

  @override
  Widget build(BuildContext context) {
    final event = dataTypeEnum == DataTypeEnum.local ? AllCharactersFetched() : CharactersFetched();
    return Scaffold(
      body: BlocProvider.value(
        value: getIt<InfiniteListBloc>()..add(event),
        child: const InfiniteList(),
      ),
    );
  }
}

class InfiniteList extends StatefulWidget {
  const InfiniteList({super.key});

  @override
  State<InfiniteList> createState() => _InfiniteListState();
}

class _InfiniteListState extends State<InfiniteList> {
  final _scrollController = ScrollController();

  @override
  void initState() {
    super.initState();
    _scrollController.addListener(_onScroll);
  }

  @override
  Widget build(BuildContext context) {
    return BlocBuilder<InfiniteListBloc, InfiniteListState>(
      builder: (context, state) {
        switch (state.status) {
          case InfiniteListStatus.failure:
            return const Center(child: Text('failed to fetch characters'));
          case InfiniteListStatus.success:
            if (state.characters.isEmpty) {
              return const Center(child: Text('no characters'));
            }
            return ListView.builder(
              itemBuilder: (BuildContext context, int index) {
                return index >= state.characters.length
                    ? const BottomLoader()
                    : CharacterListItem(character: state.characters[index]);
              },
              itemCount: state.characters.length,
              controller: _scrollController,
            );
          case InfiniteListStatus.initial:
            return const Center(child: CircularProgressIndicator());
        }
      },
    );
  }

  @override
  void dispose() {
    _scrollController
      ..removeListener(_onScroll)
      ..dispose();
    super.dispose();
  }

  void _onScroll() {
    if (_isBottom) context.read<InfiniteListBloc>().add(CharactersFetched());
  }

  bool get _isBottom {
    if (!_scrollController.hasClients) return false;
    final maxScroll = _scrollController.position.maxScrollExtent;
    final currentScroll = _scrollController.offset;
    return currentScroll >= (maxScroll * 0.9);
  }
}
